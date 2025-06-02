node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/fileport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/fileport.git'), string(name: 'PORT_DESCRIPTION', value: 'The file command is "a file type guesser", that is, a command-line tool that tells you in words what kind of data a file contains. Unlike most GUI systems, command-line *NIX systems - with this program leading the charge - do not rely on filename extentions to tell you the type of a file, but look at the actual contents of the file. This is, of course, more reliable, but requires a bit of I/O.' ), string(name: 'BUILD_LINE', value: 'STABLE') ]
  }
}
