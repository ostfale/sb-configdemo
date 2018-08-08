package de.ostfale.spring.configdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * External configuration class
 * Created :  08.08.2018
 *
 * @author : Uwe Sauerbrei
 */
@Component
@ConfigurationProperties("example")
@Validated
public class ExampleProperties {

    public static class Server {

        private String name;
        private URL url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public URL getUrl() {
            return url;
        }

        public void setUrl(URL url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Server{" + "name=" + name + ", url=" + url + '}';
        }
    }

    public static enum Environment {
        dev, prod, cloud
    }

    @NotNull
    @Size(min = 1)
    private String theGreeting;

    /**
     * Some arbitrary interval.
     */
    @Min(10)
    private Integer interval;

    private Map<Environment, Map<String, Object>> environments;
    private List<Server> servers;
    private Double precision;

    public String getTheGreeting() {
        return theGreeting;
    }

    public void setTheGreeting(String theGreeting) {
        this.theGreeting = theGreeting;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Map<Environment, Map<String, Object>> getEnvironments() {
        return environments;
    }

    public void setEnvironments(Map<Environment, Map<String, Object>> environments) {
        this.environments = environments;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    @Override
    public String toString() {
        final StringBuilder rv = new StringBuilder();
        rv
                .append("ExampleProperties{")
                .append("\n\ttheGreeting=").append(theGreeting)
                .append(",\n\tinterval=").append(interval)
                .append(",\n\tprecision=").append(precision)
                .append(",\n\tservers=").append(servers)
                .append(",\n\tenvironments=").append(environments)
                .append("\n}");
        return rv.toString();
    }
}
