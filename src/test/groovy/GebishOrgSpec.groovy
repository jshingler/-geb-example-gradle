import geb.spock.GebReportingSpec

class GebishOrgSpec extends GebReportingSpec {

    def "can get to the current Book of Geb"() {
        when: "at the Gebish Org Home Page"
        to GebishOrgHomePage

        and: "hover over to expand the menu"
        interact {
            moveToElement(manualsMenu.toggle)
        }

        then: "first link is for the current manual"
        manualsMenu.links[0].text().endsWith("- CURRENT")

        when: "click the firse menu link"
        manualsMenu.links[0].click()

        then: "at the Book of Geb Page"
        at TheBookOfGebPage

        where:
        name | value
        "abc"  | 1234
        "xyz"  | 9876
        "sss"  | 4444
    }
}