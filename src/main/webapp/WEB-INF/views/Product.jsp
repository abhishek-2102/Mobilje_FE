s<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#b1 {
width:100px;
margin-left:20px;
}
.image-preview-input {
    position: relative;
	overflow: hidden;
	margin: 0px;    
    color: #333;
    background-color: #fff;
    border-color: #ccc;    
}
.image-preview-input input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 20px;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity=0);
}
.image-preview-input-title {
    margin-left:2px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script>
	var cate = ${categoryData}
	var sup = ${supplierData}
	var prod = ${productData}

	angular.module('prodModule', []).controller('prodController',
			function($scope) {
				$scope.cate = cate;
				$scope.sup = sup;
				$scope.prod = prod;
			});
	
	$(document).on('click', '#close-preview', function(){ 
	    $('.image-preview').popover('hide');
	    // Hover befor close the preview
	    $('.image-preview').hover(
	        function () {
	           $('.image-preview').popover('show');
	        }, 
	         function () {
	           $('.image-preview').popover('hide');
	        }
	    );    
	});

	$(function() {
	    // Create the close button
	    var closebtn = $('<button/>', {
	        type:"button",
	        text: 'x',
	        id: 'close-preview',
	        style: 'font-size: initial;',
	    });
	    closebtn.attr("class","close pull-right");
	    // Set the popover default content
	    $('.image-preview').popover({
	        trigger:'manual',
	        html:true,
	        title: "<strong>Preview</strong>"+$(closebtn)[0].outerHTML,
	        content: "There's no image",
	        placement:'bottom'
	    });
	    // Clear event
	    $('.image-preview-clear').click(function(){
	        $('.image-preview').attr("data-content","").popover('hide');
	        $('.image-preview-filename').val("");
	        $('.image-preview-clear').hide();
	        $('.image-preview-input input:file').val("");
	        $(".image-preview-input-title").text("Browse"); 
	    }); 
	    // Create the preview image
	    $(".image-preview-input input:file").change(function (){     
	        var img = $('<img/>', {
	            id: 'dynamic',
	            width:250,
	            height:200
	        });      
	        var file = this.files[0];
	        var reader = new FileReader();
	        // Set preview image into the popover data-content
	        reader.onload = function (e) {
	            $(".image-preview-input-title").text("Change");
	            $(".image-preview-clear").show();
	            $(".image-preview-filename").val(file.name);            
	            img.attr('src', e.target.result);
	            $(".image-preview").attr("data-content",$(img)[0].outerHTML).popover("show");
	        }        
	        reader.readAsDataURL(file);
	    });  
	});
</script>

</head>
<body>
	<div class="container" ng-app="prodModule" ng-controller="prodController">
		<br>
		<br>
		<div style="text-align:center">
		<c:if test="${entry == true}">
	${proMessage}
	<br>
			</c:if>
			<c:if test="${error == true}">
	${proMessage}
	<br>
			</c:if>
			<c:if test="${delete == true}">
	${proMessage}
	<br>
			</c:if>
			<c:if test="${update == true}">
	${proMessage}
	<br>
			</c:if>
		</div>
		
<div class="jumbotron">
		
<c:if test="${whenSave == true}">
			<h3 style="text-align: center">Product Entry</h3>

			<form:form class="form-group" method="post" commandName="prod_form"
				action="productPage" enctype="multipart/form-data">
				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Product ID:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_id" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- Product ID-->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Product Name:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_name" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- Product name-->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Price:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_price" class="form-control" type="number"
							required="true"></form:input>
					</div>
				</div>
				<!-- Product price-->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Category ID</b>
					</div>
					<div class="col-sm-4">
						<form:select path="c_id" class="form-control" type="text"
							required="true">
							<form:option value="-1">Select Category</form:option>
							<form:option ng-repeat="cat in cate" value="{{cat.c_id}}">{{cat.c_name}}</form:option>
						</form:select>
					</div>
				</div>
				<!-- Category  ID -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Supplier ID</b>
					</div>
					<div class="col-sm-4">
						<form:select path="s_id" class="form-control" type="text"
							required="true">
							<form:option value="-1">Select supplier</form:option>
							<form:option ng-repeat="s in sup" value="{{s.s_id}}">{{s.s_name}}</form:option>
						</form:select>
					</div>
				</div>
				<!-- Supplier ID -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Stock</b>
					</div>
					<div class="col-sm-4">
						<form:input path="stock" class="form-control" type="number"
							required="true"></form:input>
					</div>
				</div>
				<!-- Stock -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Product Desc:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_desc" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- Product Description-->
				<br>
				
				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Upload Image:</b>
					</div>
					
					<div class="col-sm-4">
					<div class="input-group image-preview">
                		<input type="text" class="form-control image-preview-filename" disabled="disabled"> <!-- don't give a name === doesn't send on POST/GET -->
                		<span class="input-group-btn">
                    
                    	<button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                        	<span class="glyphicon glyphicon-remove"></span> Clear
                    	</button>
                    	<!-- image-preview-input -->
                    <div class="btn btn-default image-preview-input">
                        <span class="glyphicon glyphicon-folder-open"></span>
                        <span class="image-preview-input-title">Browse</span>
                        <form:input type="file" path="image"/>
                    </div><!-- End Image Upload -->
                </span>
            </div><!-- /input-group image-preview [TO HERE]-->
					</div>
				</div> 
				<br>
				<div class="col-sm-4 col-sm-offset-4">
					<form:button type="submit" class="btn btn-success btn-block"><b>Sumbit</b></form:button>
				</div>
			</form:form>
			<!-- End form -->
</c:if><!-- End Save -->

<c:if test="${whenUpdate == true}">

			<h3 style="text-align: center">Product Entry</h3>

			<form:form class="form-group" method="post" commandName="prod_form" action="update" enctype="multipart/form-data">
				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Product ID:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_id" class="form-control" type="text" required="true" ></form:input>
					</div>
				</div>
				<!-- Product ID-->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2" style="text-align: right; margin-top: 6px">
						<b>Product Name:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_name" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- Product name-->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2" style="text-align: right; margin-top: 6px">
						<b>Price:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_price" class="form-control" type="number"
							required="true"></form:input>
					</div>
				</div>
				<!-- Product price-->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2" style="text-align: right; margin-top: 6px">
						<b>Category ID</b>
					</div>
					<div class="col-sm-4">
						<form:select path="c_id" class="form-control" type="text"
							required="true">
							<form:option value="-1">Select Category</form:option>
							<form:option ng-repeat="cat in cate" value="{{cat.c_id}}">{{cat.c_name}}</form:option>
						</form:select>
					</div>
				</div>
				<!-- Category  ID -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2" style="text-align: right; margin-top: 6px">
						<b>Supplier ID</b>
					</div>
					<div class="col-sm-4">
						<form:select path="s_id" class="form-control" type="text"
							required="true">
							<form:option value="-1">Select supplier</form:option>
							<form:option ng-repeat="s in sup" value="{{s.s_id}}">{{s.s_name}}</form:option>
						</form:select>
					</div>
				</div>
				<!-- Supplier ID -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Stock</b>
					</div>
					<div class="col-sm-4">
						<form:input path="stock" class="form-control" type="number"
							required="true"></form:input>
					</div>
				</div>
				<!-- Stock -->
				<br>

				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Product Desc:</b>
					</div>
					<div class="col-sm-4">
						<form:input path="p_desc" class="form-control" type="text"
							required="true"></form:input>
					</div>
				</div>
				<!-- Product Description-->
				<br>
				
				<div class="row">
					<div class="col-sm-2 col-sm-offset-2"
						style="text-align: right; margin-top: 6px">
						<b>Upload Image:</b>
					</div>
					
					<div class="col-sm-4">
					<div class="input-group image-preview">
                		<input type="text" class="form-control image-preview-filename" disabled="disabled"> <!-- don't give a name === doesn't send on POST/GET -->
                		<span class="input-group-btn">
                    
                    	<button type="button" class="btn btn-default image-preview-clear" style="display:none;">
                        	<span class="glyphicon glyphicon-remove"></span> Clear
                    	</button>
                    	<!-- image-preview-input -->
                    <div class="btn btn-default image-preview-input">
                        <span class="glyphicon glyphicon-folder-open"></span>
                        <span class="image-preview-input-title">Browse</span>
                        <form:input type="file" path="image"/>
                    </div><!-- End Image Upload -->
                </span>
            </div><!-- /input-group image-preview [TO HERE]-->
					</div>
				</div> 
				<br>
				
				<div class="col-sm-4 col-sm-offset-4">
					<form:button type="submit" class="btn btn-warning btn-block"><b>Update</b></form:button>
				</div>
			</form:form><!-- End form -->
</c:if>	<!-- End update -->
		</div><!-- End jumbotron -->
		<div>
			<h3 style="margin-bottom: 10px">
				<b>Product List</b>
			</h3>
			<div class="col-sm-4">
			<div class="input-group">
  				<span class="input-group-addon"><i class="fa fa-search fa-fw"></i></span>
  				<input class="form-control" type="text" placeholder="search here..." ng-model="searchProd">
			</div><!-- End Search -->
			</div><!-- End col for search -->
			
			<table class="table table-hover">
				<thead><tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Stock</th>
					<th>Product Description</th>
					<th>Image</th>
					
				</tr></thead>

				<tbody><tr ng-repeat="pr in prod|filter:searchProd">
					<td>{{pr.p_id}}</td>
					<td>{{pr.p_name}}</td>
					<td>{{pr.p_price}}</td>
					<td>{{pr.c_id}}</td>
					<td>{{pr.s_id}}</td>
					<td>{{pr.stock}}</td>
					<td>{{pr.p_desc}}</td>
					<td><img src="upimg/{{pr.p_id}}.jpg" alt="No image" height="100px"></td>
					<td><a class="btn btn-primary" id="b1" href="updateProd?pid={{pr.p_id}}"><i class="fa fa-pencil"></i></a></td>
					<td><a class="btn btn-danger" id="b1" href="deleteProd?pid={{pr.p_id}}"><i class="fa fa-trash-o"></i></a></td>
				</tr></tbody>

			</table><!-- End view prodt -->
		</div><!-- End ng-controller for view products -->
	</div><!-- End container -->
</body>
</html>
