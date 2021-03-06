/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Hotwire, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import com.hotwire.imageassert.report.HTMLReportResultListener
import org.junit.Assert
import org.junit.Test
import java.io.File

class HTMLReportResultListenerTest {

    val outputDir = File.createTempFile(hashCode().toString(), "").run {
        delete()
        this
    }

    @Test fun testSaveReport() {
        val htmlReportResultListener = HTMLReportResultListener(outputDir)
        htmlReportResultListener.saveReport()
        Assert.assertTrue(File(outputDir, "report.json").exists())
        Assert.assertTrue(File(outputDir, "index.html").exists())
        Assert.assertTrue(File(outputDir, "css/style.css").exists())
        Assert.assertTrue(File(outputDir, "js/engine.js").exists())
        Assert.assertTrue(File(outputDir, "js/jquery-1.11.3.min.js").exists())
    }
}
