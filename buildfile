# BuildR buildfile for the RMS project
require 'buildr/scala'
require 'yaml'

VERSION_NUMBER = "0.0.0"
GROUP = "fileplan.com"
COPYRIGHT = "Proprietary Code. Do not publish or men in black will come to your door."

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://www.ibiblio.org/maven2/"

# ScalaTest requires a specific snapshot to work with Scala 2.8.0 nightly builds
# Note that download does not retrieve any dependencies (currently none required)
SCALATEST_URL = "http://www.scala-tools.org/repo-snapshots/org/scalatest/scalatest/1.0.1-for-scala-2.8.0.Beta1-SNAPSHOT/scalatest-1.0.1-for-scala-2.8.0.Beta1-SNAPSHOT.jar"
scalatest = download(artifact("org.scalatest:scalatest:jar:1.0.1") => SCALATEST_URL)


desc "Record Management System prototype"
define "fileplan" do

  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT
  
  # Tasks will go here.
  compile.with scalatest
  #task :compile => scalatest
  #task :compile => download('http://www.scala-tools.org/repo-snapshots/org/scalatest/scalatest/1.0.1-for-scala-2.8.0.Beta1-SNAPSHOT/scalatest-1.0.1-for-scala-2.8.0.Beta1-SNAPSHOT.jar')
  # Use this approach when ScalaTest has an appropriate Maven link
  # compile.with 'org.scalatest:scalatest:jar:1.0'
  
end


# Creates an ant builtfile shell to trigger buildr tasks from within Eclipse
task :ant do |task|  
  File.open 'ant.xml', 'w' do |f|
    f.write "<project name=\"default\" basedir=\"#{Dir.pwd}\">\n"
    f.write "  <description> Description would go here\n"
    f.write "  </description>\n"
    Project.tasks.each do |task|
      if task.comment != nil
        f.write "\n"
        f.write "  <target name=\"#{task.name}\"\n"
        f.write "      description=\"#{task.comment}\">\n"
        f.write "    <exec executable=\"buildr\" dir=\"#{Dir.pwd}\">\n"
        f.write "      <arg value=\"#{task.name}\" />\n"
        f.write "    </exec>\n"
        f.write "  </target>\n"
      end
    end
    f.write "</project>\n"
  end
end
