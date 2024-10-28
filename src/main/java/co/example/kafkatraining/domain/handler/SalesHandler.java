package co.example.kafkatraining.domain.handler;

import co.example.kafkatraining.domain.model.InsufficientStock;
import co.example.kafkatraining.domain.model.Item;
import co.example.kafkatraining.domain.model.LowStock;
import co.example.kafkatraining.domain.model.Sale;
import co.example.kafkatraining.domain.port.InsufficientStockProducer;
import co.example.kafkatraining.domain.port.ItemRepository;
import co.example.kafkatraining.domain.port.LowStockProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalesHandler {

    private final ItemRepository repository;
    private final LowStockProducer lowStockProducer;
    private final InsufficientStockProducer insufficientStockProducer;


    public void process(Sale sale) {

        for (Item itemSale: sale.getItems()){

            Optional<Item> entityOptional = repository.findById(itemSale.getId());

            if (entityOptional.isPresent()) {
                Item item = entityOptional.get();
                try{
                    item.decreaseQuantity(itemSale.getQuantity());
                } catch (Exception e) {
                    InsufficientStock message2 = InsufficientStock.builder()
                            .id(itemSale.getId())
                            .saleId(sale.getSaleId())
                            .customerId(sale.getCustomerId())
                            .description("Inventory insufficient stock for sale with %s quantity".formatted(item.getQuantity()))
                            .build();
                    insufficientStockProducer.send(message2);
                }
                repository.save(item);
                if (item.getQuantity() < 100 ){
                    LowStock message5 = LowStock.builder()
                            .id(itemSale.getId())
                            .saleId(sale.getSaleId())
                            .customerId(sale.getCustomerId())
                            .description("Inventory near out of stock %s".formatted(item.getQuantity()))
                            .build();
                    lowStockProducer.send(message5);
                }
            }
        }
    }
}

