<%--
  Created by IntelliJ IDEA.
  User: tapusd
  Date: 3/8/21
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href =
                  "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
          rel = "stylesheet">

    <script src =
                    "https://code.jquery.com/jquery-1.10.2.js">
    </script>

    <script src =
                    "https://code.jquery.com/ui/1.10.4/jquery-ui.js">
    </script>
    <style>
        #img-div{
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
        }
        img{
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<h2>Open file:</h2>
<%--<input type="file" name="image1" id="image1" onchange="get_cover_image_detail(this)">--%>
<form id="image-form" action="<c:url value="/multiple/upload" />" method="POST" enctype="multipart/form-data">
    <input type="file" name="images" id="images" onchange="get_look_inside(this)" multiple>
    <input type="hidden" name="image-names-in-re-order" id="image-names-in-re-order" value="">
    <input type="submit" value="Submit">
</form>

<div id="img-div">

</div>

<div id="outputvalues"></div>

<script>

    var imgDiv = document.getElementById("img-div");
    var form = document.getElementById("image-form");

    function get_cover_image_detail(input) {
        let file = input.files[0];
        console.log(input.files[0]);
        var reader = new FileReader();

        reader.onload = function(e) {
            let img = document.getElementById("img-preview");
            img.setAttribute("src", e.target.result);
            img.removeAttribute("hidden");
            console.log(e.target.result);
        }

        reader.readAsDataURL(file);
    }

    function get_look_inside(input) {
        let counter = 1;
        let files = input.files;
        console.log(files);

        var reader = new FileReader();
        reader.onload = function(e) {
            let div = document.createElement('div');
            div.setAttribute("id", "imageNo" + counter);
            div.setAttribute("class", "listitemClass");

            let img = document.createElement("img");
            img.setAttribute("width", "400px");
            img.setAttribute("height", "250px");
            img.setAttribute("src", e.target.result);
            div.appendChild(img);

            imgDiv.appendChild(div);
        }

        reader.onloadend = function(e) {
            if (counter < files.length) {
                reader.readAsDataURL(files[counter]);
            }
            counter+=1;
        }

        reader.readAsDataURL(files[0]);

    }

    $(function() {
        $( "#img-div" ).sortable({
            update: function(event, ui) {
                getIdsOfImages();
            }//end update
        });
    });

    function getIdsOfImages() {
        var values = [];
        $('.listitemClass').each(function (index) {
            values.push($(this).attr("id").toString().replace("imageNo", ""));
        });
        let input = $('#image-names-in-re-order');
        console.log(input);
        input.attr("value", values.toString());

        // values.forEach(function (value) {
        //     $('#image-form').find('.hidden-input').delete();
        //
        //     let hiddenInputOrder = document.createElement("input");
        //     hiddenInputOrder.setAttribute("type", "hidden");
        //     hiddenInputOrder.setAttribute("class", "hidden-input");
        //     hiddenInputOrder.setAttribute("name", "image-names-in-re-order");
        //     hiddenInputOrder.setAttribute("value", value);
        //
        //     form.appendChild(hiddenInputOrder);
        // })

    }
</script>
</body>
</html>