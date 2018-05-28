#def gitUrl = 'git://github.com/jenkinsci/job-dsl-plugin.git'

folder('project-a') {
    displayName('Project A')
    description('Folder for project A')
}
folder('project-a/AAA') {
    displayName('job AAA')
    description('Folder containing all QA jobs for project A')
}
