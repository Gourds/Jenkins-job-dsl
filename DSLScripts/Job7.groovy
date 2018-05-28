job('example2') {
    parameters {
        activeChoiceParam('CHOICE') {
            description('Allows user choose from multiple choices')
            filterable(filterable = false)
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('''
def sout = new StringBuffer(), serr = new StringBuffer()
def proc ='aws --region cn-north-1 s3 ls s3://itbackups/gamexback/pay'.execute(
['AWS_ACCESS_KEY_ID=xxxx','AWS_SECRET_ACCESS_KEY=xxxxx'], null)
proc.consumeProcessOutput(sout, serr)
proc.waitForOrKill(2000)
//println sout
def ret = [:]
sout.toString().split('\\n').each{
  def sp = it.split(' ')
  def fn = sp[-1]
  def dd = Date.parse('yyyy-MM-dd hh:mm:ss', sp[0..1].join(' ')).format('yyyyMMddhhmmss')
  ret[dd] =fn
}
ret = ret.sort(Collections.reverseOrder())

def r = [:]
ret.each { k, v ->
  r[v] = v + ' @ ' + k
}
return r
''')
                fallbackScript('return ["haha"]')
            }
        }
    }
}
