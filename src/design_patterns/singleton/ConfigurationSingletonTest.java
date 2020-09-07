package design_patterns.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * TODO ASZ: comment me!
 */
public class ConfigurationSingletonTest {
    @Test
    public void assureThatGetInstanceReturnsAlwaysTheSameObject() {
        final ConfigurationSingleton conf = ConfigurationSingleton.getInstance();
        final ConfigurationSingleton repeatedConf = ConfigurationSingleton.getInstance();

        assertThat(conf).isNotNull();
        assertThat(conf).isSameAs(repeatedConf);
    }
}
