<?php
    require_once('header.php');
    $user_id = 0;
if(isset($_SESSION["role"]) && !empty($_SESSION["role"]) && $_SESSION['role'] == 1){

?>

    </head>
    <div class="wrapper">
        <div class="container">
            <div class="container_paid">
                <h1 id="main_title">Ordered items:</h1>
            </div>
            <div class="container_information">
                <?php
                $sql = "SELECT facture.date, facture.sum, laptops.laptop_name, korisnici.username, facture_item.quantity FROM facture_item 
                        JOIN facture ON facture.facture_id = facture_item.facture_id
                        JOIN korisnici ON korisnici.id = facture.user_id 
                        JOIN laptops ON laptops.laptop_id = facture_item.laptop_id'";
                if($result = mysqli_query($conn, $sql)){
                    if($stmt = mysqli_query($conn, $sql)) {
                        if (mysqli_num_rows($result) > 0) {
                            ?>
                            <table class="table table-bordered table-striped tabela">
                                <thead>
                                <tr>
                                    <th>User name</th>
                                    <th>Laptop name</th>
                                    <th>Date ordered</th>
                                    <th>Total price</th>
                                    <th>Quantity</th>
                                </tr>
                                </thead>
                                <tbody>
                                <?php
                                while($row = mysqli_fetch_array($stmt)) {
                                    echo "<tr>";
                                    echo "<td>" . $row['korisnik.username'] . "</td>";
                                    echo "<td>" . $row['laptops.laptop_name'] . "</td>";
                                    echo "<td>" . $row['facture.date'] . "</td>";
                                    echo "<td>$" . $row['facture.sum'] . "</td>";
                                    echo "<td>" . $row['facture_item.quantity'] . "</td>";
                                    echo "</tr>";
                                }
                                ?>
                                </tbody>
                            </table>
                            <?php
                        } else {
                            echo "ERROR: " . mysqli_error($conn);
                        }
                    } else {
                        echo "ERROR: " . mysqli_error($conn);
                    }
                }
                ?>
                <a href="details.php"><button class="button btn-read-more" type="submit" value="Go Back" name="back">Back</button></a>
            </div>
        </div>
    </div>
<?php
    require_once('footer.php');
} else {
    header("location: index.php");
    exit();
}
?>
    </body>
</html>
