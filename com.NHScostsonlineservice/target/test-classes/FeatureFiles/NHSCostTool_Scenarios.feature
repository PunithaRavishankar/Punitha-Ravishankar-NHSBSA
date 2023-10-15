Feature: Get Help with paying for NHS costs online service.

  Scenario Outline: Check what help you could get to pay for NHS costs by selecting Country as England
    Given navigating to NHS Costs Checker tool
    When user accepts or declines the cookies if flag is selected as [accept_cookies: "<accept_cookies>"]
    When clicking on Start Now to access the Link
    When I am a citizen of the UK by selecting country as England
    When Select GP practice in Scotland or Wales? Yes
    When Select country dental practice in? England
    When Enter date of birth in Day DD : "<Date>"
    When Enter date of birth in  Month MM :"<Month>"
    When Enter date of birth in  Year YYYY :"<Year>"
    When Select live with a partner as Yes
    When Select you or your partner claim any benefits or tax credits? as Yes
    When Select you or your partner get paid Universal Credit? as Yes, we receive Universal Credit payments
    When Select As part of your joint Universal Credit, do you have any of these? As Yes
    When Select Did you and your partner have a combined take-home pay of £935 or less in your last Universal Credit period? As Yes

    Examples: 
      | accept_cookies | Date | Month | Year |
      | Y              |   28 |    12 | 1989 |

  Scenario Outline: Check what help you could get to pay for NHS costs by selecting Country as Scotland
    Given navigating to NHS Costs Checker tool
    When user accepts or declines the cookies if flag is selected as [accept_cookies: "<accept_cookies>"]
    When clicking on Start Now to access the Link
    When I am a citizen of the UK by selecting country as Scotland
    When Select do you live in the Highlands and Islands? as Yes
    When Select country dental practice in? as I am not registered with a dental practice
    When Enter date of birth in Day DD : "<Date>"
    When Enter date of birth in  Month MM :"<Month>"
    When Enter date of birth in  Year YYYY :"<Year>"
    When Select live with a partner as No
    When Select you or your partner claim any benefits or tax credits? as No
    When Select are you pregnant or have you given birth in the last 12 months as No
    When Select do you have an injury or illness caused by serving in the armed forces? as No
    When Select do you live permanently in a care home? as No
    When Select do you and your partner have more than £16,000 in savings, investments or property? No
    Then Click on Back Button to change you and your partner have more than £16,000 in savings, investments or property? Yes from No
    Then Going back to Select country dental practice in? Change Scotland to as I am not registered with a dental practice

    Examples: 
      | accept_cookies | Date | Month | Year |
      | Y              |   17 |    06 | 1994 |

  Scenario Outline: Check what help you could get to pay for NHS costs by selecting Country as Northern Ireland
    Given navigating to NHS Costs Checker tool
    When user accepts or declines the cookies if flag is selected as [accept_cookies: "<accept_cookies>"]
    When clicking on Start Now to access the Link
    Then I am a citizen of the UK by selecting country as Northern Ireland

    Examples: 
      | accept_cookies |
      | Y              |

  Scenario: Accessing the link in Date of Birth Page
    Given navigating to NHS Costs Checker tool
    When clicking on Start Now to access the Link
    When I am a citizen of the UK by selecting country as Wales
    When Is your GP practice in Scotland or Wales? As No
    When Select country dental practice in? as Wales
    Then Click on the Why we ask for your date of birth link

  Scenario: Clicking Next without Selecting any Radio Button
    Given navigating to NHS Costs Checker tool
    When clicking on Start Now to access the Link
    When I am a citizen of the UK by selecting country as Scotland
    Then Select do you live in the Highlands and Islands? as Blank
