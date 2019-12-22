module pl.koziolekweb.pwm {
    requires java.logging;
    requires com.google.common;

    opens pl.koziolekweb.pwm.byexample;
    opens pl.koziolekweb.pwm.parameters;
    opens pl.koziolekweb.pwm.properties;
}
