# J-T-Core for Ecore

Author: Pierre-Olivier Talbot \
Editors: Sebastien Ehouan, Théo Le Calvar, An Li

## Description

J-T-Core for Ecore is a framework for designing model transformation languages using 8 primitive modules: Matcher, Iterator, Rewriter, Resolver, Rollbacker, Selector, Synchronizer and Composer.

## Typical usage

A sample Main class is provided: `MainTest`.

**Important:** The `utils.initialize()` function must always be invoked before importing models. \
This project requires Java 11 and add all libraries in the `lib/` directory in the classpath.

Here is a typical workflow:
1. Import metamodels
2. Import models and patterns
3. Create initial packet
4. Create rules using the `RuleFactory`
5. Run packet through rules
6. Save model changes

## Ramifier

Ramifier is provided in `j-t-core/Ramifier_New` \
To run the ramifier, please run the following ATL transformations in the below order, with the paths to the models specified:
1. `j-t-core/Ramifier_New/Relax.atl`
2. `j-t-core/Ramifier_New/Augment_pre.atl`
3. `j-t-core/Ramifier_New/Augment_post.atl`
4. `j-t-core/Ramifier_New/Augment_compo.atl`

Note: To be able to run the transformations, when creating the configuration, go to the Advanced tab, select "EMF-specific VM", and check "Allow inter-model references" under "Advanced parameters".

## Unit Tests

Several Unit tests are provided in `j-t-core/src/unit/tests`.

To run them, you need:
* A metamodel
* The ramified version of the metamodel
* A dynamic instance of the metamodel
* A Precondition corresponding to the model
* NACs (Optional)
* Conditions defined to match the label IDs of the attributes, not used for VF2 in this iteration (Expected output)

The resources mentioned aboved are to be predefined in `j-t-core/Ramifier_New/Model`
