def sout = new StringBuffer(), serr = new StringBuffer()
def proc ='aws --region xxxxx s3 ls s3://backup/gamex/${zipPrefix}'.execute(
['AWS_ACCESS_KEY_ID=xxxxx', 'AWS_SECRET_ACCESS_KEY=xxxxxx'], null)
proc.consumeProcessOutput(sout, serr)
proc.waitForOrKill(2000)
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
