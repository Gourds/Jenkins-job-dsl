job('project-a/ansible-test4') {
    scm {
        git{
            remote{
                name('dada')
                url('git@172.21.0.11:/data/go-project/go-test')
                credentials('git-pass')
            }
	}
    }
    parameters {
        stringParam('myname', 'my default stringParam value', '描述：文本选项') //字符变量设置,单行输入框
        textParam('myword', '不要为了看别人而走错了脚下的路', 'my description') //文本变量设置,多行输入框
    }
    triggers {
        cron('#15 13 * * *')
    }
    steps {
        shell('echo $myname $myword')
        environmentVariables {
            envs(ANSIBLE_ROLES_PATH: 'ansible-deploy/roles', ANSIBLE_LOOKUP_PLUGINS: 'ansible-deploy/lookup_plugins',ANSIBLE_ETCD_URL: 'http://etcd.test.net:2379')
        }
        ansiblePlaybook('b.yml') {
            inventoryPath('ansible-deploy/hosts')
            ansibleName('ansible')
            limit('all,localhost')
            credentialsId('jenkins-pass')
            forks(150)
            unbufferedOutput(true)
            colorizedOutput(true)
        }
    }
}
