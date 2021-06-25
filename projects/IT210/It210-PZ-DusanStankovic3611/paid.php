<?php
require_once('header.php');
$total = 0;
if(isset($_SESSION['username'])){
    require_once('dbutil/dbConnection.php');

    foreach($_SESSION['cart'] as $key => $row){
        $total = $total +($row['quantity'] * $row['laptop_price']);
        $sql = "INSERT INTO `facture` (`sum`,`user_id`) VALUES (?, ?)";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "ii", $psum, $puid);
            $psum = $total;
            $puid = $_SESSION['user_id'];
            if (mysqli_stmt_execute($stmt)) {

            } else {
                echo "ERROR: " . mysqli_error($conn);
            }
        } else {
            echo "ERROR: " . mysqli_error($conn);
        }

        $user_id = $_SESSION['user_id'];
        $facture_id = 0;
        $sql = "SELECT facture_id FROM facture WHERE user_id = '$user_id'";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            if ($result = mysqli_query($conn, $sql)) {
                if ($stmt = mysqli_query($conn, $sql)) {
                    if (mysqli_num_rows($result) > 0) {
                        while ($red = mysqli_fetch_array($result)) {
                            $facture_id = $red['facture_id'];
                        }
                    } else {
                        echo "ERROR: " . mysqli_error($conn);
                    }
                } else {
                    echo "ERROR: " . mysqli_error($conn);
                }
            }
        }

        $sql = "INSERT INTO `facture_item` (`quantity`, `price`, `laptop_id`, `facture_id`) VALUES (?,?,?,?)";
        if ($stmt = mysqli_prepare($conn, $sql)) {
            mysqli_stmt_bind_param($stmt, "idii", $pquantity, $pprice, $plpid, $facid);
            $pquantity = $row['quantity'];
            $pprice = $row['laptop_price'];
            $plpid = $row['laptop_id'];
            $facid = $facture_id;
            if (mysqli_stmt_execute($stmt)) {

            } else {
                echo "ERROR: " . mysqli_error($conn);
            }
        } else {
            echo "ERROR: " . mysqli_error($conn);
        }
    }

?>
        <title>Thank you for your purchase!</title>
        <style>
            #main_title {
                text-align: center;
            }
            .paid_p {
                text-align: center;
            }
            .container_paid {
                margin: 50px 0;
                position: relative;
                height: 100%;
                width: 100%;
            }
            h2 {
                text-align: center;
            }
            th {
                color: white;
            }
            td {
                color: white;
            }
            a {
                color: white;
            }
            .container_information {
                margin: 120px 0;
            }
        </style>
    </head>

        <div class="wrapper">
            <div class="container">
                <div class="container_paid">
                <h1 id="main_title">Thank you for your purchase!</h1>
                    <p class="paid_p">Expect your items to arrive shorty!</p>
                </div>
                <div class="container_information">
                    <h2>Items that you ordered</h2>
                    <?php
                    if(!empty($_SESSION['cart'])):
                        $total = 0;
                        foreach($_SESSION['cart'] as $key => $row):
                    ?>
                    <table class="table table-bordered table-striped tabela">
                            <thead>
                                <tr>
                                    <th>User name</th>
                                    <th>Laptop name</th>
                                    <!--    <th>Date ordered</th>   --->
                                    <th>Total price</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                            <?php

                                echo "<tr>";
                                echo "<td>" . $_SESSION['username'] . "</td>";
                                echo "<td>" . $row['laptop_name'] . "</td>";
                               // echo "<td>" . $row['date'] . "</td>";
                                echo "<td>$" . number_format($row['laptop_price'] , 2) . "</td>";
                                echo "<td>" . $row['quantity'] . "</td>";
                                echo "</tr>";
                                endforeach;
                            ?>
                            </tbody>
                    </table>
                    <?php
                        endif;
                    ?>
                    <a href="index.php"><button class="button btn-read-more" type="submit" value="kupi_bre" name="purchase">Back</button></a>
                </div>
            </div>
        </div>
    </body>
</html>
<?php
    require_once('footer.php');
} else {
    header('location: index.php');
    exit();
}
?>
