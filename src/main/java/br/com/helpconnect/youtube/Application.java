package br.com.helpconnect.youtube;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.helpconnect.youtube.controller.YoutubeController;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "br.com.helpconnect.youtube.controller")
@Import({ YoutubeController.class })
@EntityScan(basePackages = {"br.com.helpconnect.models.model"})
@EnableJpaRepositories(basePackages = {"br.com.helpconnect.repositorys.repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}