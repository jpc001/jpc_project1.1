# BuildR buildfile for the RMS project
require 'buildr/scala'
require 'yaml'

VERSION_NUMBER = "0.0.0"
GROUP = "fileplan.com"
COPYRIGHT = "Proprietary Code. Do not publish or men in black will come to your door."

SCALATEST_VER = "2.8.0.Beta1-SNAPSHOT"
# ScalaTest requires a specific snapshot to work with Scala 2.8.0 nightly builds
SCALATEST_URL = "http://www.scala-tools.org/repo-snapshots/org/scalatest/scalatest/1.0.1-for-scala-#{SCALATEST_VER}/scalatest-1.0.1-for-scala-#{SCALATEST_VER}.jar"

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://www.ibiblio.org/maven2/"

scalatest = download(artifact("local:scalatest:jar:#{SCALATEST_VER}")=>SCALATEST_URL)


desc "Record Management System prototype"
define "fileplan" do
  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT
  
  compile.with scalatest

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

#
# The following will fix the scalatest 0.9.5 dependency issue that causes
# BuildR to fail (FeatureSpec trait does not exist in 0.9.5), but we need
# to identify the root cause of the 0.9.5 dependency.
#
#module Buildr::Scala
#  class ScalaTest
#    class << self
#      def dependencies
#        ["org.scalatest:scalatest:jar:#{SCALATEST_VER}"] + Check.dependencies +
#          JMock.dependencies + JUnit.dependencies
#      end
#    end
#  end
#end 