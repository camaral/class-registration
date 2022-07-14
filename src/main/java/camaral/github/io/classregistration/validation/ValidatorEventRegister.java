package camaral.github.io.classregistration.validation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Fix to bug https://github.com/spring-projects/spring-data-rest/issues/898
 */
@Configuration
public class ValidatorEventRegister implements InitializingBean {

    ValidatingRepositoryEventListener validatingRepositoryEventListener;

    private Map<String, Validator> validators;

    public ValidatorEventRegister(ValidatingRepositoryEventListener validatingRepositoryEventListener,
                                  Map<String, Validator> validators) {
        this.validatingRepositoryEventListener = validatingRepositoryEventListener;
        this.validators = validators;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<String> events = Arrays.asList("beforeLinkSave");
        for (Map.Entry<String, Validator> entry : validators.entrySet()) {
            events.stream()
                    .filter(p -> entry.getKey().startsWith(p))
                    .findFirst()
                    .ifPresent(
                            p -> validatingRepositoryEventListener
                                    .addValidator(p, entry.getValue()));
        }
    }
}
