package service;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;
import model.Auction;
import model.State;
import model.User;

@Configuration
@Slf4j
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(AuctionRepository repository, UserRepository userRepository) {	
		return (args) -> {
			User user0 = new User("Tony", "Soprano", "tonyS", "tonySoprano@gmail.com", "pass", new java.util.Date());
			User user1 = new User("Corrado", "Soprano", "UncleJun", "SopranoJr@gmail.com", "pass", new java.util.Date());
			User user2 = new User("Paulie", "Gualtieri", "GuantieriP", "PaulieG@gmail.com", "pass", new java.util.Date());
			User user3 = new User("Christopher", "Moltisanti", "ChrisMoltisanti", "Moltisanti@gmail.com", "pass", new java.util.Date());
			User user4 = new User("Salvatore", "Bompensiero", "pussy", "pussy@gmail.com", "pass", new java.util.Date());
			User user5 = new User("Silvio", "Dante", "DanteNJ", "DanteS@gmail.com", "pass", new java.util.Date());
			Auction auction0 = new Auction("Mascara de Corrado.S", "la usa para no roncar y aliviar su viejo corazón", "address", 1000, 
					new java.util.Date(), new java.util.Date(), 12);
			Auction auction1 = new Auction("Chaqueta de Richie Aprile", "De gran valor sentimental para este. Tony la desecho", "address", 200, 
					new java.util.Date(), new java.util.Date(), 12);
			Auction auction2 = new Auction("Gorro Corrado Jr", "Lo usa para cubrir su prominente calvicie", "address", 5000, 
					new java.util.Date(), new java.util.Date(), 12);
			Auction auction3 = new Auction("Mate Tony. S", "un mate normal", "address", 5000, 
					new java.util.Date(), new java.util.Date(), 12);
			Auction auction4 = new Auction("Terere Tony. S", "un terere normal", "address", 5000, 
					new java.util.Date(), new java.util.Date(), 12);
			
			
			Auction auction5 = new Auction("Iphone 6 fffffffff", "Robado por Chris Moltisanti", "address", 1000, 
					LocalDate.now().plusDays(1).toDate(), LocalDate.now().plusDays(1).toDate(), 12);
			Auction auction6 = new Auction("Camion de ropa fffffffff", "Robados por Tony. S", "address", 200, 
					LocalDate.now().plusDays(1).toDate(), LocalDate.now().plusDays(2).toDate(), 12);
			Auction auction7 = new Auction("Libreta ffffffffff", "propiedad de la Dr. Melfi", "address", 5000, 
					LocalDate.now().plusDays(1).toDate(), LocalDate.now().plusDays(3).toDate(), 12);
			Auction auction8 = new Auction("Nintendo64 ffffffff", "Consola videojuegos de Anthony Soprano. Jr", "address", 5000, 
					LocalDate.now().plusDays(1).toDate(), LocalDate.now().plusDays(2).toDate(), 12);
			Auction auction9 = new Auction("Restaurant ffffffff", "Restaurante el Vesubio, propiedad de Artie Bucco", "address", 5000, 
					LocalDate.now().plusDays(1).toDate(), LocalDate.now().plusDays(3).toDate(), 12);
			
			
			auction0.setState(State.ENPROGRESO);
			auction1.setState(State.ENPROGRESO);
			auction2.setState(State.ENPROGRESO);
			auction3.setState(State.ENPROGRESO);
			auction4.setState(State.ENPROGRESO);
			
			auction5.setState(State.ENPROGRESO);
			auction6.setState(State.ENPROGRESO);
			auction7.setState(State.ENPROGRESO);
			auction8.setState(State.ENPROGRESO);
			auction9.setState(State.ENPROGRESO);
			
			user0.addAuction(auction3);
			user0.addAuction(auction0);
			auction3.addAPic("https://upload.wikimedia.org/wikipedia/en/thumb/c/c2/Tony_Soprano.jpg/270px-Tony_Soprano.jpg");
			auction0.addAPic("https://upload.wikimedia.org/wikipedia/en/thumb/4/4f/Silvio_Dante-_Sopranos.png/220px-Silvio_Dante-_Sopranos.png");
			
			auction1.addAPic("https://i.pinimg.com/originals/3b/14/c8/3b14c8243204b71217eb78d9fcd8b457.jpg");
			auction2.addAPic("https://upload.wikimedia.org/wikipedia/en/6/64/JuniorSoprano.jpg");
			
			
			auction1.addBidder(user0);
			auction2.addBidder(user0);
			
			
			//repository.save(auction1);
			userRepository.save(user0);
			
			
			// fetch all auctions
			log.info("Employers found with findAll():");
			log.info("-------------------------------");
			for (Auction auction : repository.findAll()) {
				log.info(auction.toString());
			}
			log.info("");

			// fetch an individual auction by ID
			repository.findById(1L)
				.ifPresent(auction -> {
					log.info("Auction found with findById(1L):");
					log.info("--------------------------------");
					log.info(auction.toString());
					log.info("");
				});

			// fetch customers by name
			log.info("Customer found with findByName('Jack'):");
			log.info("--------------------------------------------");
			repository.findByTitle("Guantelete del Infinito").forEach(guantelete -> {
				log.info(guantelete.toString());
			});
			
			log.info("");
		};
		
	}

}
