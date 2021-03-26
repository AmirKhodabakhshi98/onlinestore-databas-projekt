CREATE PROCEDURE deleteProduct

    @Product_id int
AS




BEGIN
    if (11 NOT EXISTS (SELECT Order_product.Product_id FROM Order_product WHERE Order_product.Product_id= 11))
    BEGIN
        BEGIN TRAN
            BEGIN TRY

                    DELETE from Product_discount WHERE Product_discount.Product_id=@Product_id

                    DELETE from Product
                     WHERE Product_id = @Product_id AND (NOT EXISTS
                        (SELECT*
                        FROM Order_product
                        WHERE Order_product.Product_id= @Product_id))

                COMMIT TRANSACTION

            END TRY
        BEGIN CATCH
            ROLLBACK TRANSACTION

        END CATCH
   END
END

GO