package com.seprokof;

import java.io.File;

import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;

/**
 * Application entry point. Deploys application on the embedded container.
 * 
 * @author seprokof
 *
 */
public class Main {

    public static void main(String[] args) throws GlassFishException {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Please specify path to ear file to deploy");
        } else {
            System.out.println("Deploying -> " + args[0]);
        }

        GlassFishProperties glassfishProperties = new GlassFishProperties();
        glassfishProperties.setPort("http-listener", 1234);
        glassfishProperties.setPort("https-listener", 5678);

        GlassFish glassfish = GlassFishRuntime.bootstrap().newGlassFish(glassfishProperties);
        glassfish.start();

        Deployer deployer = glassfish.getDeployer();
        deployer.deploy(new File(args[0]), "--force=true");
    }

}