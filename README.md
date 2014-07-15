Study
=====

Choose between ExecutorService's submit and ExecutorService's execute
=====
    A task queued with execute() that generates some Throwable will cause the UncaughtExceptionHandler for the Thread running the task to be invoked. The default UncaughtExceptionHandler, which typically prints the Throwable stack trace to System.err, will be invoked if no custom handler has been installed.
    
    On the other hand, a Throwable generated by a task queued with submit() will bind the Throwable to the Future that was produced from the call to submit(). Calling get() on that Future will throw an ExecutionException with the original Throwable as its cause (accessible by calling getCause() on the ExecutionException).
    
