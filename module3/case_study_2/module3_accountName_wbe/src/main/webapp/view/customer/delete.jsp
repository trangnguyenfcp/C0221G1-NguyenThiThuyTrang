<h1>Delete customer</h1>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Customer ID: </td>
                <td>${customer.customer_id}</td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${customer.customer_name}</td>
            </tr>

            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customer">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>