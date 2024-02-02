
# Docker Build cmd
docker compose up --build -d

# sales-management API

API to return the order list of the current day -
http://localhost:8080/api/order/current-day

API to return the total sale amount of the current day -
http://localhost:8080/api/order/total-amount-current-day

API to return all the registered customer list -
http://localhost:8080/api/customer/list

API to return the entire order list of a customer -
http://localhost:8080/api/customer/{{customerId}}/orders

API to return the max sale day of a certain time range -
http://localhost:8080/api/order/max-sale-date
