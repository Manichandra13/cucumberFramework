#Feature file to capture the below Core Web Vitals for both Desktop and Mobile
#Largest Contentful Paint (LCP)
#First Input Delay (FID)
#Cumulative Layout Shift (CLS)

@CoreWebVital
Feature: Core Web Vital Automation

  Scenario: Captures the Core Web Vitals for both Desktop and Mobile
  Given Login to Google Search Console and navigate to Core Web Vitals section
  When Capture the Core Web Vitals metrics for both Desktop and Mobile  
  Then mail the report to all stakeholders
