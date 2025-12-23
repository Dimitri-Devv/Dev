package fr.dawan.formationtdd.services;

import static org.hamcrest.Matchers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repositories.ProductRepository;
import services.DiscountService;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DiscountServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private DiscountService discountService;

    public void remiseProduit(){
        Product p = new Product(2l,"smartphone", 650);
        when(repository.findById(2L)).thenReturn(Optional.of(p));
        Product result=service.remiser(150.0, 2);
        assertThat(result, Matchers.samePropertyValuesAs(p, "prix"));
        assertEquals(500.0, result.getPrix());
    }

    public void productNotFound(){
        when(repository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> service.remiser(200.0, ))
    }
}
