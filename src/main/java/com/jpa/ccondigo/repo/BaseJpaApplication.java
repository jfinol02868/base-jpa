package com.jpa.ccondigo.repo;

import com.jpa.ccondigo.repo.entity.Client;
import com.jpa.ccondigo.repo.entity.Invoice;
import com.jpa.ccondigo.repo.entity.uno.uno.OneToOneService;
import com.jpa.ccondigo.repo.repository.AddressRepository;
import com.jpa.ccondigo.repo.repository.ClientRepository;
import com.jpa.ccondigo.repo.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaseJpaApplication implements CommandLineRunner {

	private final AddressRepository addressRepository;
	private final ClientRepository clientRepository;
	private final InvoiceRepository invoiceRepository;
	private final OneToOneService oneToOneService;

	public BaseJpaApplication(AddressRepository addressRepository, ClientRepository clientRepository, InvoiceRepository invoiceRepository, OneToOneService oneToOneService) {
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
		this.invoiceRepository = invoiceRepository;
        this.oneToOneService = oneToOneService;
    }

	public static void main(String[] args) {
		SpringApplication.run(BaseJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oneToOneService.runCreate();

		oneToOneService.runUpdate();

		oneToOneService.deleteRun();
	}


//	@Transactional
//	public void oneToMane() {
//
//		// Creamos la dirección
//		Address addressOne = Address.builder()
//				.street("Calle 1")
//				.city("Madrid")
//				.country("España")
//				.postalCode("30008")
//				.build();
//
//		Address addressTwo = Address.builder()
//				.street("Calle 1")
//				.city("Caracas")
//				.country("Venezuela")
//				.postalCode("1080")
//				.build();
//
//		// Creamos el cliente
//		Client client = Client.builder()
//				.name("Marisol")
//				.lastName("Mendez")
//				.addresses(List.of(addressOne, addressTwo))
//				.build();
//
//		// Guardamos el cliente
//		System.out.println("Create cliente !!");
//		clientRepository.save(client);
//		System.out.println(client);
//	}

//	@Transactional
//	public void oneToManyFindById() {
//		// Creamos la dirección
//		Address addressOne = Address.builder()
//				.street("Calle 1")
//				.city("Madrid")
//				.country("España")
//				.postalCode("30008")
//				.build();
//
//		Address addressTwo = Address.builder()
//				.street("Calle 1")
//				.city("Caracas")
//				.country("Venezuela")
//				.postalCode("1080")
//				.build();
//
//		// Creamos el cliente
//		Client client = clientRepository.findById(5L).orElseThrow();
//		client.setAddresses(List.of(addressOne, addressTwo));
//
//		// Guardamos el cliente
//		System.out.println("Create cliente !!");
//		clientRepository.save(client);
//		System.out.println(client);
//	}

	@Transactional
	public void manyToOneCreateClient() {

		// Creamos el cliente o lo recuperamos si ya existe
		Client client = Client.builder()
				.id(5L)
				.name("Jesus")
				.lastName("Finol")
				.build();

		// Guardamos el cliente si no existe
		clientRepository.save(client);

		// Creamos la factura para ese cliente
		Invoice invoice = Invoice.builder()
				.idClient(5L)
				.description("First invoice")
				.total(1000L)
				.client(client)
				.build();

		// Guardamos la factura asociada al cliente
		Invoice invoiceResponse =  invoiceRepository.save(invoice);
		System.out.println(invoiceResponse);

		Invoice invoiceTwo = Invoice.builder()
				.idClient(5L)
				.description("Second invoice")
				.total(2000L)
				.client(client)
				.build();

		Invoice invoiceResponseTow =  invoiceRepository.save(invoiceTwo);
		System.out.println(invoiceResponseTow);
	}

	@Transactional
	public void manyToOneGetClientById() {
		// Recuperamos el cliente
		Client client = clientRepository.findById(6L).orElseThrow();

		// Creamos la factura
		Invoice invoice = Invoice.builder()
				.description("Tercera invoice")
				.total(5000L)
				.client(client)
				.build();

		// Guardamos la factura asociada al cliente
		Invoice invoiceResponse =  invoiceRepository.save(invoice);
		System.out.println(invoiceResponse);
	}
}
