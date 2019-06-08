<%--
  Created by IntelliJ IDEA.
  User: ed
  Date: 27.05.2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Turnstile</title>
    <link rel="stylesheet" href="design.css">
    <script>
        (function () {
            var path = document.location.pathname.replace(/^.*\/([^\/]+)$/, '$1');
            window.onpopstate = function () {
                history.pushState({}, "", path);
            };
            history.pushState({}, "", path);
        })();
    </script>
</head>
<body>


<table>
    <tr>
        <td>
            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post">
                <select name="selectTurnstile" ${disabledButton}; onchange="this.form.submit()">
                    <option value="turnstile0" ${selectedTurnstile0}>Turnstile#0</option>
                    <option value="turnstile1" ${selectedTurnstile1}>Turnstile#1</option>
                    <option value="turnstile2" ${selectedTurnstile2}>Turnstile#2</option>
                    <option value="turnstile3" ${selectedTurnstile3}>Turnstile#3</option>
                    <option value="turnstile4" ${selectedTurnstile4}>Turnstile#4</option>
                </select>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <p><img src="img/cardReceiver.png"
                    alt="cardReceiver"
                    style="margin-left: 65px;
                        margin-top: 50px">
            </p>
        </td>
        <td>
            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post"
                  style="display: inline-block;  margin-top: 70px;">
                <input ${disabledSensor1};
                       ${onClickSensor1};
                       class="myClass"
                       type="submit"
                       name="sensor1"
                       value="Sensor1"
                       style="margin-left: 150px; background: ${sensor1Color}"/>
                <input type="hidden" name="command" value="clickSensor1">
            </form>

            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post"
                  style="display: inline-block;  margin-top: 70px;">
                <input ${disabledSensor2};
                       ${onClickSensor2};
                       class="myClass"
                       type="submit"
                       name="sensor2"
                       value="Sensor2"
                       style="margin-left: 25px; background: ${sensor2Color}"/>
                <input type="hidden" name="command" value="clickSensor2">
            </form>

            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post"
                  style="display: inline-block;  margin-top: 70px;">
                <input ${disabledSensor3};
                       ${onClickSensor3};
                       class="myClass"
                       type="submit"
                       name="sensor3"
                       value="Sensor3"
                       style="margin-left: 25px; background: ${sensor3Color}"/>
                <input type="hidden" name="command" value="clickSensor3">
            </form>
        </td>

        <td>
            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post">
                <input ${disabledButton}
                       type="submit"
                       class="buttonInsertToDB"
                       name="toDB"
                       value="DB">
                <input type="hidden" name="command" value="clickDb">
            </form>
        </td>

        <td>
            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post">
                <p class="errorMessage">${errorMessage}</p>
                <input ${disabledButton}; type="text" name="login" placeholder="Login" required>
                <br>
                <input ${disabledButton}; type="password" name="password" placeholder="Password" required>
                <br>
                <input ${disabledButton}; type="submit" value="Submit">

                <input type="hidden" name="command" value="clickLogin">
            </form>
        </td>
    </tr>

    <tr>
        <td>
            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post" style="display: inline-block">
                <input ${disabledButton};
                       class="myAnotherClass"
                       type="submit"
                       name="button1"
                       value="Attach a valid card"
                       style="margin-left: 50px;
                          margin-top: 50px"/>
                <input type="hidden" name="command" value="clickButton1">
            </form>

            <br/>

            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post" style="display: inline-block">
                <input ${disabledButton}
                       class="myAnotherClass"
                       type="submit"
                       name="button2"
                       value="Attach an invalid card (expiration date)"
                       style="margin-left: 50px;
                           margin-top: 50px"/>
                <input type="hidden" name="command" value="clickButton2">
            </form>

            <br/>

            <form action="/courseorkJava_Turnstile_exploded/myUrl" method="post" style="display: inline-block">
                <input ${disabledButton};
                       class="myAnotherClass"
                       type="submit"
                       name="button3"
                       value="Attach an invalid card (number of trips)"
                       style="margin-left: 50px;
                           margin-top: 50px"/>
                <input type="hidden" name="command" value="clickButton3">
            </form>
        </td>

        <td>
            <p><img src=${indicatorImage};
                    alt="indicator"
                    style="margin-left: 225px;
                        margin-top: 50px">
            </p>
        </td>
    </tr>
</table>

<script>
    function myFunction() {
        alert("Access denied!");
    }
</script>

<script>
    /*<![CDATA[*/
    document.addEventListener('DOMContentLoaded', function () {

        var flag = ${refresh};
        console.log(flag);

        if (flag === true) {
            alert("${strForWarning}");
        }

    });
    /*]]>*/
</script>

</body>
</html>
