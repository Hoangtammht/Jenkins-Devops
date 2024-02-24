pipeline {
    agent {
        label 'lab-server'
    }
    environment {
            appUser = "weatherappbackend"
            appName = "WeatherAppBackEnd"
            appVersion = "0.0.1-SNAPSHOT"
            appType = "jar"
            processName = "${appName}-${appVersion}.${appType}"
            folderDeploy = "/projects/${appName}"
            buildScript = "mvn clean install -DskipTests=true"
            copyScript = "sudo cp target/${processName} ${folderDeploy}"
            permsScript = "sudo chown -R ${appUser}. ${folderDeploy}"
            killScript = "sudo kill -9 \$(ps -ef| grep ${processName}| grep -v grep| awk '{print \$2}')"
            runScript = 'sudo su ${appUser} -c "cd ${folderDeploy}; java -jar ${processName} > nohup.out 2>&1 &"'
    }
    stages {
        stage('info') {
            steps {
                sh(script: """ whoami;pwd;ls -la """, label: "first stage")
            }
        }

        stage('build') {
                    steps {
                        sh(script: """ ${buildScript} """, label: "build with maven")
                    }
                }
    }


}