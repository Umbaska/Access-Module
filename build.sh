#!/usr/bin/env bash
echo "Building The Access Module"
mvn clean install
echo "Finished building the module"

for i in "$@" ; do
    if [[ $i == "server" ]] ; then
        echo "Setting up the server"
        if [ ! -f run/spigot.jar ]; then
            echo "Spigot was not found, building now!"
            mkdir -p spigotbuild
            cd spigotbuild/
            curl -O https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar
            java -jar BuildTools.jar
            cp spigot-*.jar ../run/spigot.jar
            cd ../
        fi
        mkdir -p run
        mkdir -p run/plugins/Umbaska/modules
        cp ../Umbaska/target/Umbaska.jar run/plugins/Umbaska.jar
        if [ ! -f run/plugins/Skript.jar ]; then
            curl -L -o run/plugins/Skript.jar https://github.com/bensku/Skript/releases/download/dev25/Skript.jar
        fi
        cp target/AccessModule.jar run/plugins/Umbaska/modules/AccessModule.jar
        echo "Finished setting up the server, run spigot.jar in the run/ directory (setup a run profile in your IDE)"
        break
    fi
done