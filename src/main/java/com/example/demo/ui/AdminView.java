package com.example.demo.ui;

import com.example.demo.backend.Book;
import com.example.demo.backend.BookService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;

import javax.annotation.security.RolesAllowed;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {

    BookService service;

    public AdminView(BookService service) {
        this.service = service;
        add(
                headerTitle(),
                gridComponent()
        );
    }

    private Component gridComponent() {
        var crud = new GridCrud<>(Book.class, service);
        crud.getGrid().setColumns("title", "published", "rating");
        crud.getCrudFormFactory().setVisibleProperties("title", "published", "rating");
        crud.getCrudFormFactory().setUseBeanValidation(true);
        crud.setAddOperationVisible(true);
        return crud;
    }

    private Component headerTitle() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(new H1("Gerenciar Livros"));
        verticalLayout.setAlignItems(Alignment.CENTER);

        return verticalLayout;

    }

}
