# Java Pairing Test - Guitar Shop


## Brief
This application takes a CSV of sales records for a guitar shop and generates some basic reports.

Now the owner of the shop would like to have some new features added - some new reports, integration with their new
point of sale system and HTML reporting.

They would also like to ensure that that the application can be extended in the future. 

### Code quality 
Take a look at the code. How could it be improved? How could it be made easier to work with in future?

Apply these changes to the code, explaining your decisions as you go.

### New reports
The shop owner would like to know two additional things. Add these new sections to the report:

* Their average weekly sales revenue
* The most popular product to be sold on a Friday

### POS integration
The new point of sale system exposes a JSON REST API from which you can fetch sales records.

A development server for this API can be started on this machine by running:

`./start-pos-api.sh`

This will start the server on `localhost` on port `8000`.

The API returns sales reports by period.
Here's an example of how to fetch the same data as in the original CSV from the API:

`curl http://localhost:8000/api/sales/period/1`

Update the application so that it retrieves its sales records from this API.


### HTML reporting
The shop owner finds the monospaced console reports to be dull and unappealing. They would like an HTML report to be
generated instead.

Add the ability to generate an HTML report. Bonus points if you can make it easy on the eye!


