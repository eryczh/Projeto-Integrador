package configurations;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TesteConfiguracao {
    
    @Autowired
    MyNameService myNameService;

    private boolean instanciar() throws ParseException {
        this.myNameService.instanciarDB();
        return true;
    }
}
