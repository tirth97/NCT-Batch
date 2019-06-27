The src files have two parts: 'appserver' and 'batchserver'. 
    The appserver has the following:
        BatchCmdSender.java: takes user input and sends batch job command to the queue.
        BatchNotificationReceiver.java: receives notification when batch jobs are complete

    The batchserver has the following:
	BrokerStarter.java: starts JMS queue. This should be run on server startup.
        BatchCmdReceiver.java: consumes messages from the queue and call JobRunner to execute the batch jobs, and setups the notification sender.
        JobRunner.java: Parses input messages and execute corresponding batch jobs.
	folder hadoopjob: defines a few batch jobs. For each batch job, after it finishes, the program will send notification to a queue, and the appserver side will receive the notification.

Tomcat server configuration:
        in the folder conf_backup

Demo:
        1. Start Tomcat server, run the BrokerStarter in batchserver; 
        2. Run both programs in appserver and "BatchCmdReceiver" on in batchserver.
        2. Type in messages to the "BatchCmdSender" in appserver.