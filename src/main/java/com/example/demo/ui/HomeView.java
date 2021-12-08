package com.example.demo.ui;

import com.example.demo.backend.Book;
import com.example.demo.backend.BookService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.List;

@Route("")
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView(BookService service) {
        Grid<Book> grid = new Grid<>(Book.class);
        grid.setColumns("title", "published", "rating");
        List<Book> all = service.findAll();
        grid.setItems(all);
        add(
               headerTitle(),
                grid
        );
    }

    private VerticalLayout headerTitle(){
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(new H1("Livros"));
        verticalLayout.setAlignItems(Alignment.CENTER);
        return verticalLayout;
    }
}
