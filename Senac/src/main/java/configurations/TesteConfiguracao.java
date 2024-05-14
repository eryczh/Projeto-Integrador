package configurations;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import services.ImovelService;

@Configuration
@Profile("teste")
public class TesteConfiguracao {
    
    @Autowired
    ImovelService myImovelService;

    @SuppressWarnings("unused")
    private boolean instanciar() throws ParseException {
        this.myImovelService.instanciarDB();
        return true;
    }
}
