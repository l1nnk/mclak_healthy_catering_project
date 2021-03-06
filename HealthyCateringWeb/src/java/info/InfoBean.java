/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import locale.MessageHandler;
import locale.MessageType;
import shopping.customer.CorporateCustomer;
import shopping.customer.Customer;
import shopping.customer.PrivateCustomer;
import shopping.product.Product;
import shopping.product.SingleProduct;
import user.User;

/**
 *
 * @author Karl
 */
@Named
@SessionScoped
public class InfoBean implements Serializable {

    private ArrayList<Order> activeOrders = new ArrayList<Order>();
    private Customer selectedCustomer;
    private Customer selectedOrderCustomer;
    private Order selectedOrder;
    
    private boolean detailOrder;
    private boolean editCustomer;
    @Inject
    private CustomerHandler customerHandler;
    @Inject
    private ProductHandler productHandler;

    public InfoBean() {
        ArrayList<Product> temp = new ArrayList<Product>();
        temp.add(new SingleProduct(123, "Yup", "Good", 130, 130));
        temp.add(new SingleProduct(123, "Yup", "Good", 130, 130));
        temp.add(new SingleProduct(123, "Yup", "Good", 130, 130));
        temp.add(new SingleProduct(123, "Yup", "Good", 130, 130));
        temp.add(new SingleProduct(123, "Yup", "Good", 130, 130));

        activeOrders.add(new Order(1, 666, temp, new Date(2013, 04, 17), new Date(2013, 04, 18), new Date(2013, 04, 19)));
    }

    public ArrayList<Order> getActiveOrders() {
        //TODO Get non-delivered orders from DB
        return activeOrders;
    }

    public ArrayList<Order> getOrderHistory() {
        //TODO Get delived orders from DB
        return activeOrders;
    }

    public void editCustomer(Customer customer) {
        selectedCustomer = customer;
        editCustomer = true;
    }

    public void lookUpOrder(int orderID) {
        // TODO: Get customer from DB
        selectedOrder = activeOrders.get(0);
        selectedOrderCustomer = new PrivateCustomer(123456, "møkje@penge.no", "Rikbotnfjord", "99 99 33 33", 5670, "Okidokiland", "Langnavnesen", "Ivar");
        detailOrder = true;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public Customer getSelectedOrderCustomer() {
        return selectedOrderCustomer;
    }

    public void setSelectedOrderCustomer(Customer selectedOrderCustomer) {
        this.selectedOrderCustomer = selectedOrderCustomer;
    }
    
    public Order getSelectedOrder() {
        return selectedOrder;
    }

    public boolean isCustomerOrder() {
        return detailOrder;
    }

    public boolean isPopupEditCustomer() {
        return editCustomer;
    }

    public void closeDetailedInfo() {
        selectedCustomer = null;
        detailOrder = false;
    }

    public void closeEditCustomer() {
        selectedCustomer = null;
        editCustomer = false;
    }

    public ArrayList<Customer> getAllCustomers() {
        return customerHandler.getAllCustomers();
    }

    public ArrayList<User> getAllUsers() {
        return null;
    }

    public ArrayList<Product> getAllProducts() {
        return productHandler.getAllProducts();
    }

    public String getFirstName() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getFirstName();
            }
        }
        return null;
    }

    public void setFirstName(String firstname) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setFirstName(firstname);
            }
        }
    }

    public String getLastName() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getLastName();
            }
        }
        return null;
    }

    public void setLastName(String lastname) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setLastName(lastname);
            }
        }
    }

    public String getCompanyName() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getCompanyName();
            }
        }
        return null;
    }

    public void setCompanyName(String companyName) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setCompanyName(companyName);
            }
        }
    }

    public String getEmail() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getEmail();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getEmail();
            }
        }
        return null;
    }

    public void setEmail(String email) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setEmail(email);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setEmail(email);
            }
        }
    }

    public String getAddress() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getAddress();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getAddress();
            }
        }
        return null;
    }

    public void setAddress(String address) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setAddress(address);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setAddress(address);
            }
        }
    }

    public String getZipCode() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return Integer.toString(customer.getZipCode());
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return Integer.toString(customer.getZipCode());
            }
        }
        return null;
    }

    public void setZipCode(String zip) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                try {
                    customer.setZipCode(Integer.parseInt(zip));
                } catch (Exception e) {
                }
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                try {
                    customer.setZipCode(Integer.parseInt(zip));
                } catch (Exception e) {
                }
            }
        }
    }

    public String getCity() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getCity();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getCity();
            }
        }
        return null;
    }

    public void setCity(String city) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setCity(city);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setCity(city);
            }
        }
    }

    public String getPhoneNumber() {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                return customer.getPhoneNumber();
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                return customer.getPhoneNumber();
            }
        }
        return null;
    }

    public void setPhoneNumber(String number) {
        if (selectedCustomer != null) {
            if (selectedCustomer instanceof PrivateCustomer) {
                PrivateCustomer customer = (PrivateCustomer) selectedCustomer;
                customer.setPhoneNumber(number);
            } else if (selectedCustomer instanceof CorporateCustomer) {
                CorporateCustomer customer = (CorporateCustomer) selectedCustomer;
                customer.setPhoneNumber(number);
            }
        }
    }

    public boolean selectedLoggedInAsPrivate() {
        if (selectedCustomer instanceof PrivateCustomer) {
            return true;
        }
        return false;
    }

    public String saveChangesCustomer() {
        if (customerHandler.fixCustomer(selectedCustomer)) {
            String msg = MessageHandler.getLocalizedText(MessageType.TEKST, "edit_account_changes_saved");
            MessageHandler.addErrorMessage(msg);
        } else {
            String msg = MessageHandler.getLocalizedText(MessageType.ERROR, "edit_account_changes_not_saved");
            MessageHandler.addErrorMessage(msg);
        }
        return "";
    }
}