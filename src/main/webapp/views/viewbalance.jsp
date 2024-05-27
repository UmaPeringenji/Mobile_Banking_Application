<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<center>
<center>
<h1>SDFC BANK</h1>
<h2>EXTRADORANY SERVICES</h2>
<a href="/reg">NEW ACCOUNT</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/balance">BALANCE</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/deposit">DEPOSIT</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/withdraw">WITHDRAW</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/transfer">TRANSFER</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/about">ABOUT</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/close">CLOSE</a>&nbsp;&nbsp;&nbsp;&nbsp;

</center>

<table border="1">
<tr>
<th>ACNO</th>
<th>USERNAME</th>
<th>AMOUNT</th>
<th>ADDRESS</th>
<th>PHONE</th>
</tr>
<tr>
<td>${bank.acno}</td>
<td>${bank.name}</td>
<td>${bank.amount}</td>
<td>${bank.address}</td>
<td>${bank.mobile}</td>
</tr>
</table>
