from tensorflow.examples.tutorials.mnist import input_data

mnist = input_data.read_data_sets("/tmp/data/", one_hot = True)

import tensorflow as tf

learning_rate = 0.01
training = 30
batch_size = 100

x = tf.placeholder("float", [None, 784])
y = tf.placeholder("float", [None, 10])

weight = tf.Variable(tf.zeros([784, 10]))
bias = tf.Variable(tf.zeros([10]))

model = tf.nn.softmax(tf.matmul(x, weight) + bias)

cost = -tf.reduce_sum(y * tf.log(model))

opt = tf.train.GradientDescentOptimizer(learning_rate).minimize(cost)

init = tf.global_variables_initializer()

with tf.Session() as sess:
    sess.run(init)

    for iteration in range(training):
        avg_cost = 0.
        total_batch = int(mnist.train.num_examples / batch_size)

        for i in range(total_batch):
            batch_xs, batch_ys = mnist.train.next_batch(batch_size)

            sess.run(opt, feed_dict={x: batch_xs, y: batch_ys})

            avg_cost += sess.run(cost, feed_dict={x: batch_xs, y: batch_ys}) / total_batch

    predictions = tf.equal(tf.argmax(model, 1), tf.argmax(y, 1))

    accuracy = tf.reduce_mean(tf.cast(predictions, "float"))
    print("Accuracy:", accuracy.eval({x: mnist.test.images, y: mnist.test.labels}))