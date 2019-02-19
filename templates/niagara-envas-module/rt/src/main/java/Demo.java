package ${pkg} ;

import com.neopsis.envas.NvDesktopUI;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Theme("envas")
public class Demo extends NvDesktopUI {

    @Override
    protected void init(VaadinRequest request) {

        super.init(request);

        VerticalLayout layout = new VerticalLayout();
        TextField      field  = new TextField("Please enter your name:");
        Button         button = new Button("Click me!");

        button.addClickListener(new Button.ClickListener() {

                                    @Override
                                    public void buttonClick(Button.ClickEvent clickEvent) {
                                        layout.addComponent(new Label("Thank you, " + field.getValue()));
                                    }

                                });
        layout.addComponent(field);
        layout.addComponent(button);
        layout.setSpacing(true);
        layout.setMargin(true);
        setContent(layout);
    }
}
