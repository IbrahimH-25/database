<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>DavesTimber</title></head>
<body style="background-color:LightGreen">
	<div align="center">
	<h1>Welcome to DavesTimber</h1 style="background-color:DarkGoldenRod">
		<p> ${errorOne } </p>
		<p> ${errorTwo } </p>
		<form action="insertTree">
			<table border="1" cellpadding="5" style="background-color:DarkGoldenRod">
				<tr>
					<th>Number of trees you wish to cut: </th>
					<td align="center" colspan="3">
						<select onchange="addItems()"  name="number of trees">
							<option value="0" hidden>0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						</select>
					</td>
				</tr>
			</table>
								<button type="submit">Request a Quote</button>
				<form action = ${reloadQuoteTable} >
					<input type = "submit" value = "reload"/>
				</form>
			<a href="login.jsp" target="_self">Return to Login Page</a>

		</form>
	</div>
	<script>
		function addItems(){
			const select = document.getElementsByName("number of trees")[0];
			const number = select.options[select.selectedIndex].value;
			const table = document.getElementsByTagName("table")[0];
			const rows = table.rows.length;
			for(let i=rows-1;i>=1;i--){
				table.deleteRow(i);
			}
			for(let i=1;i<=number;i++){
				const row=table.insertRow(-1);
				const c1=row.insertCell(0);
				const c2=row.insertCell(1);
				c1.innerText="Tree "+(i);
				c2.innerText="";
				const sizeRow=table.insertRow(-1);
				const sizeCell=sizeRow.insertCell(0);
				const sizeCell2=sizeRow.insertCell(1);
				sizeCell.innerText="Size: ";
				const sizeInput=document.createElement("input");
				sizeInput.type="text";
				sizeInput.name="size"+i;
				sizeInput.required=true;
				sizeCell2.appendChild(sizeInput);
				const heightRow=table.insertRow(-1);
				const heightCell=heightRow.insertCell(0);
				const heightCell2=heightRow.insertCell(1);
				heightCell.innerText="Height: ";
				const heightInput=document.createElement("input");
				heightInput.type="text";
				heightInput.name="height"+i;
				heightInput.required=true;
				heightCell2.appendChild(heightInput);
				const feetOrNo=table.insertRow(-1);
				const feetOrNoCell=feetOrNo.insertCell(0);
				const feetOrNoCell2=feetOrNo.insertCell(1);
				feetOrNoCell.innerText="Is the tree less than 10 feet away from the home? (yes/no) : ";
				const feetOrNoInput=document.createElement("input");
				feetOrNoInput.type="radio";
				feetOrNoInput.name="feetOrNo"+i;
				feetOrNoInput.value="yes";
				feetOrNoInput.required=true;
				feetOrNoCell2.appendChild(feetOrNoInput);
				const label=document.createElement("label");
				label.innerText="yes";
				label.htmlFor= "feetOrNo"+i;
				feetOrNoCell2.appendChild(label);
				const feetOrNoInput2=document.createElement("input");
				feetOrNoInput2.type="radio";
				feetOrNoInput2.name="feetOrNo"+i;
				feetOrNoInput2.value="no";
				feetOrNoInput2.required=true;
				feetOrNoCell2.appendChild(feetOrNoInput2);
				const label2=document.createElement("label");
				label2.innerText="no";
				label2.htmlFor= "feetOrNo"+i;
				feetOrNoCell2.appendChild(label2);
				// 3 image uploads
				const imageRow=table.insertRow(-1);
				const imageCell=imageRow.insertCell(0);
				const imageCell2=imageRow.insertCell(1);
				imageCell.innerText="Upload 3 images of the tree: ";
				const imageLabel = document.createElement("label");
				imageLabel.innerText="Image 1";
				imageLabel.htmlFor="images"+i;
				imageLabel.style.marginRight="10px"
				imageCell2.appendChild(imageLabel);
				const imageInput=document.createElement("input");
				imageInput.type="file";
				imageInput.name="images"+i;
				imageInput.required=true;
				imageCell2.appendChild(imageInput);
								const imageLabel2 = document.createElement("label");
				imageLabel2.innerText="Image 2";
				imageLabel2.htmlFor="images"+i;
								imageLabel2.style.marginRight="10px"
				imageCell2.appendChild(imageLabel2);
				const imageInput2=document.createElement("input");
				imageInput2.type="file";
				imageInput2.name="images"+i;
				imageInput2.required=true;
				imageCell2.appendChild(imageInput2);
				const imageLabel3 = document.createElement("label");
				imageLabel3.innerText="Image 3";
				imageLabel3.htmlFor="images"+i;
								imageLabel3.style.marginRight="10px"
				imageCell2.appendChild(imageLabel3);
				const imageInput3=document.createElement("input");
				imageInput3.type="file";
				imageInput3.name="images"+i;
				imageInput3.required=true;
				imageCell2.appendChild(imageInput3);
			}
		}
	</script>
</body>