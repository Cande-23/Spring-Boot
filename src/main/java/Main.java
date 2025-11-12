import com.utn.productos.model.Categoria;
import com.utn.productos.model.Producto;
import com.utn.productos.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductosApiApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ProductoRepository repo) {
        return args -> {
            repo.save(new Producto(null, "Auriculares Bluetooth", "Auriculares inalámbricos", 99.99, 15, Categoria.ELECTRONICA));
            repo.save(new Producto(null, "Remera Deportiva", "Remera de algodón", 19.9, 40, Categoria.ROPA));
            repo.save(new Producto(null, "Cereal Integral", "Caja 500g", 4.5, 100, Categoria.ALIMENTOS));
            repo.save(new Producto(null, "Juego de Ollas", "Set 5 piezas", 129.0, 8, Categoria.HOGAR));
            repo.save(new Producto(null, "Pelota de Fútbol", "Talle oficial", 29.99, 25, Categoria.DEPORTES));
        };
    }
}
