package edu.firstwebapp.spring5webapp.bootstrap;

import edu.firstwebapp.spring5webapp.model.Author;
import edu.firstwebapp.spring5webapp.model.Book;
import edu.firstwebapp.spring5webapp.model.Publisher;
import edu.firstwebapp.spring5webapp.repositories.AuthorRepository;
import edu.firstwebapp.spring5webapp.repositories.BookRepository;
import edu.firstwebapp.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric =  new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","A123456");
        Publisher pub1 = new Publisher("Publis ","London");



        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        pub1.getBooks().add(ddd);

        ddd.setPublishers(pub1);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub1);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE","561565");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Bootstrap Started");
        System.out.println("Number of Books"+bookRepository.count());
        System.out.println("Number of Publishers"+publisherRepository.count());



    }
}
