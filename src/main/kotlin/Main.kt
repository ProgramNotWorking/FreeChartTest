package org.example
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.JFreeChart
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import javax.swing.JFrame
import kotlin.math.sin

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val dataset = XYSeriesCollection()
    val wSeries = XYSeries("w(t)")
    val bSeries = XYSeries("b")
    val aSeries = XYSeries("a")
    val xSeries = XYSeries("x(t)")

    val a = -1.0
    val l = 1.0
    val b = 2.996
    val w0 = 0.0
    val K = 1000000.0
    val T = 40.0

    // x(t) function example
    fun x(t: Double) = 3 * sin(t)

    for (t in 0..(T * 10).toInt() step 1) {
        val w = w0 // w(0) solving method here
        wSeries.add((t / 10).toDouble(), w)
        bSeries.add((t / 10).toDouble(), b)
        aSeries.add((t / 10).toDouble(), a)
        xSeries.add((t / 10).toDouble(), x((t / 10).toDouble()))
    }

    dataset.addSeries(wSeries)
    dataset.addSeries(bSeries)
    dataset.addSeries(aSeries)
    dataset.addSeries(xSeries)

    val chart: JFreeChart = ChartFactory.createXYLineChart(
        "График",
        "t",
        "y",
        dataset
    )

    val frame = JFrame("График")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.add(ChartPanel(chart))
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}