package app.planer


import spock.lang.Specification

class PlanerApplicationTestsAlt extends  Specification {

	def contextLoads() {
		given:
		def a = 1
		when:
		a +=2
		then:
		a == 2
	}

	def "CIEKAWE CZY COS SIE DZIEJE "() {
		expect:
		a == 2 * b
		where:
		a | b
		1 | 2
		2 | 3
		8 | 4
	}


}
