job('project-a/ansible-test6') {
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
        activeChoiceParam('foo') {
            description('Allows user choose from multiple choices')
            filterable()
            choiceType('SINGLE_SELECT')//https://jenkinsci.github.io/job-dsl-plugin/#path/job-parameters-activeChoiceParam-choiceType
            groovyScript {
                script('return["aaa","bbb","ccc"]')
                fallbackScript('"fallback choice"')
            }
        }
        activeChoiceParam('bar') {
            description('Allows user choose from multiple choices')
            filterable()
            choiceType('CHECKBOX')
            groovyScript {
                script('return["a3","b3","c3"]')
                fallbackScript('"fallback choice"')
            }
        }
    }
    steps {
        shell('echo $foo $bar')
    }
}
