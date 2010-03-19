# BuildR buildfile for the RMS project
require 'buildr/scala'
require 'yaml'

VERSION_NUMBER = "0.0.0"
GROUP = "fileplan.com"
COPYRIGHT = "Copyright © Reposinet 2010"

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://www.ibiblio.org/maven2/"

# Get ScalaTest via Maven repository
# 19/03/2010 - Currently, ScalaTest requires a specific beta release to work with Scala 2.8.0 nightly builds
SCALATEST_VER = "1.0.1-for-scala-2.8.0.Beta1-NQRFPT"
scalatest = artifact("org.scalatest:scalatest:jar:#{SCALATEST_VER}")

# Alternate download location for ScalaTest
#SCALATEST_VER = "2.8.0.Beta1-SNAPSHOT"
#SCALATEST_URL = "http://www.scala-tools.org/repo-snapshots/org/scalatest/scalatest/1.0.1-for-scala-#{SCALATEST_VER}/scalatest-1.0.1-for-scala-#{SCALATEST_VER}.jar"
#scalatest = download(artifact("local:scalatest:jar:#{SCALATEST_VER}")=>SCALATEST_URL)

desc "Record Management System prototype"
define "fileplan" do
  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT
  
  test.with scalatest
  test.using :scalatest

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

task :eclipse => :ant

#
# BuildR attempts to use ScalaTest 0.9.5, which does not contain the
# FeatureSpec class used by our test classes.  The following is a temporary
# workaround that redefines the dependencies for the scala.test class so that
# BuildR uses the correct ScalaTest release (1.0.1).
#
# See: http://issues.apache.org/jira/browse/BUILDR-332
#
module Buildr::Scala
  class ScalaTest
    class << self
      def dependencies
        ["org.scalatest:scalatest:jar:#{SCALATEST_VER}"] + Check.dependencies +
          JMock.dependencies + JUnit.dependencies
      end
    end
  end
end 

