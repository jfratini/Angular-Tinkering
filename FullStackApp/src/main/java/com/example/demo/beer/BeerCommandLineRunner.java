package com.example.demo.beer;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BeerCommandLineRunner implements CommandLineRunner {

	private final BeerRepository repository;
	private final Logger LOG = LoggerFactory.getLogger(BeerCommandLineRunner.class);

	public BeerCommandLineRunner(BeerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		// Top beers from https://www.beeradvocate.com/lists/top/
		Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius", "Budweiser", "Coors Light",
				"PBR").forEach(name -> repository.save(new Beer(name)));
		for (Beer b : repository.findAll()) {
			LOG.info(b.toString());
		}
	}

}
