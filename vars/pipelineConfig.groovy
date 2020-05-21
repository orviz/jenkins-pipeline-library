//@Library(['github.com:WORSICA/jenkins-pipeline-library@docker-compose'])
//import eu.indigo.parser.ConfigParser
import eu.indigo.compose.parser.ConfigValidator
//import eu.indigo.compose.*

def call(String yamlName) {
    dir(env.WORKSPACE) {
        println "In workspace: ${env.WORKSPACE}"
        def yaml = readYaml file: yamlName
        ConfigValidator.validate(yaml)
    }

    def buildNumber = Integer.parseInt(env.BUILD_ID)
    /*
    // load project's configuration
    ProjectConfiguration projectConfig = ConfigParser.parse(yaml, env)

    def imageName = projectConfig.dockerConfiguration.imageName().toLowerCase()

    // build the image specified in the configuration
    def customImage = docker.build(imageName, "--file ${projectConfig.dockerfile} .")

    // adds the last step of the build.
    def closure = buildSteps(projectConfig, customImage)

    // each service is a closure that when called it executes its logic and then calls a closure, the next step.
    projectConfig.services.each {

        closure = "${it.service.getVar()}"(projectConfig, it.version, closure)
    }

    // we execute the top level closure so that the cascade starts.
    try {
        closure([:])
    } finally{
        deleteDockerImages(projectConfig)
    }
    */
}
