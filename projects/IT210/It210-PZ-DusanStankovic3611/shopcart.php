<?php
    require_once('header.php');
    $ogquv = "";
    if(isset($_SESSION['username'])) {
        require_once('dbutil/dbConnection.php');

        if (filter_input(INPUT_GET, 'action') == 'delete') {
            //prolazi kroz sve laptopove u shopping cart dok se ne matchuje sa GET id promenljivom
            foreach ($_SESSION['cart'] as $key => $row) {
                if ($row['laptop_id'] == filter_input(INPUT_GET, 'laptop_id')) {

                    /* $test = $row['laptop_id'];
                    //Uzimam quantity iz baze
                    $sql = "SELECT quantity FROM laptops WHERE laptop_id = '$test'";
                    if ($result = mysqli_query($conn, $sql)) {
                        if ($stmt = mysqli_query($conn, $sql)) {
                            if (mysqli_num_rows($result) > 0) {
                                while ($row = mysqli_fetch_array($result)) {
                                    $ogquv = $row['quantity'];
                                }
                            } else {
                                echo "ERROR: " . mysqli_error($conn);
                            }
                        } else {
                            echo "ERROR: " . mysqli_error($conn);
                        }
                    }
                    //Dodajem izvuceni quantity iz cart u stanje laptopa
                    $squv = $row['quantity'];
                    if ($ogquv == $squv) {
                        $total = $ogquv + $squv;
                        $sql = "UPDATE `laptops` SET `quantity` = ? WHERE `laptop_id` = '$test'";
                        if ($stmt = mysqli_prepare($conn, $sql)) {
                            mysqli_stmt_bind_param($stmt, 'i', $changed_quantity);
                            $changed_quantity = $total;
                            if (mysqli_stmt_execute($stmt)) {
                                header("location: shopcart.php");
                            } else {
                                echo "ERROR: " . mysqli_error($conn);
                            }
                        } else {
                            echo "ERROR" . mysqli_error($conn);
                        }
                    }
                    */
                    //Brise laptop iz shopping carta
                    unset($_SESSION['cart'][$key]);
                }
            }
            $_SESSION['cart'] == array_values($_SESSION['cart']);
        }

?>
<head>
    <title>Shopping cart</title>
</head>
<body>
<div class="wrapper">
    <div class="px-4 px-lg-0">
        <!-- For demo purpose -->
        <div class="container text-white py-5 text-center">
            <h1 class="display-4">Purchase your laptop</h1>
            <p class="lead mb-0">If you are done or satisfied with out product click on the button down below to proceed to the checkout. </p>
            <p class="lead">Thank you, <a href="index.php" class="text-white font-italic">
                    <u>Yours truly IT210.</u></a>
            </p>
        </div>

        <div class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                        <!-- Shopping cart table -->
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="p-2 px-3 text-uppercase">Product</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Original Price</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Quantity</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Price with quantity</div>
                                    </th>
                                    <th scope="col" class="border-0 bg-light">
                                        <div class="py-2 text-uppercase">Remove</div>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <?php
                                    if(!empty($_SESSION['cart'])):
                                        $total = 0;
                                        foreach($_SESSION['cart'] as $key => $row):
                                ?>
                                <tr>
                                    <td><?php echo $row['laptop_name'] ?></td>
                                    <td>$ <?php echo number_format($row['laptop_price'] , 2) ?></td>
                                    <td><?php echo $row['quantity'] ?></td>
                                    <td>$ <?php echo number_format($row['quantity'] * $row['laptop_price'], 2); ?></td>
                                    <td>
                                        <a href="shopcart.php?action=delete&laptop_id=<?php echo $row['laptop_id']?>">
                                            <i class="fa fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                                <?php $total = $total +($row['quantity'] * $row['laptop_price']);
                                        endforeach;
                                ?>
                                </tbody>
                            </table>
                        </div>
                        <!-- End -->
                    </div>
                </div>

                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon code</div>
                        <div class="p-4">
                            <p class="font-italic mb-4">If you have a coupon code, please enter it in the box below</p>
                            <div class="input-group mb-4 border rounded-pill p-2">
                                <input type="text" placeholder="Apply coupon" aria-describedby="button-addon3" class="form-control border-0">
                                <div class="input-group-append border-0">
                                    <button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill"><i class="fa fa-gift mr-2"></i>Apply coupon</button>
                                </div>
                            </div>
                        </div>
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
                        <div class="p-4">
                            <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
                            <textarea name="" cols="30" rows="2" class="form-control"></textarea>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                        <div class="p-4">
                            <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                            <ul class="list-unstyled mb-4">
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>$390.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Shipping and handling</strong><strong>$10.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>
                                <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                                    <h5 class="font-weight-bold" style="color: #101010">$ <?php echo number_format($total, 2) ?></h5>
                                </li>
                            </ul>
                            <?php
                                if(isset($_SESSION['cart'])):
                                if(count($_SESSION['cart']) > 0):
                            ?>
                            <a href="paid.php"><input class="btn btn-dark rounded-pill py-2 btn-block" type="submit" name="buy" value="Proceed To Checkout"></a>
                            <?php endif; endif; endif;?>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<?php
    } else {
        header("location: index.php");
        exit();
}
?>
</body>
</html>
